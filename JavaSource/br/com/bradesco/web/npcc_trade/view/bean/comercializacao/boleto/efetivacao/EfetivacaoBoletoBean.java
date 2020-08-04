package br.com.bradesco.web.npcc_trade.view.bean.comercializacao.boleto.efetivacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.bradesco.web.aq.application.error.BradescoViewException.BradescoViewExceptionActionType;
import br.com.bradesco.web.aq.application.util.faces.BradescoFacesUtils;
import br.com.bradesco.web.aq.view.components.UICalendarPeriod.CalendarPeriodDataType;
import br.com.bradesco.web.aq.view.components.UICnpj.CnpjDataType;
import br.com.bradesco.web.aq.view.components.UICpf.CpfDataType;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.BolAgexListService;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexListVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.BolAgexVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.boleto.boletoAgexList.bean.StatusBolAtzFiltroVO;
import br.com.bradesco.web.npcc_trade.service.business.comercializacao.precificacao.negociacao.bean.ClienteSelecaoVO;
import br.com.bradesco.web.npcc_trade.utils.Numeros;
import br.com.bradesco.web.npcc_trade.utils.SiteUtil;
import br.com.bradesco.web.npcc_trade.utils.components.CalendarioPeriodo;
import br.com.bradesco.web.npcc_trade.utils.enums.EnumProduto;
import br.com.bradesco.web.npcc_trade.view.bean.SelectItemBean;
import br.com.bradesco.web.npcc_trade.view.bean.global.clienteModal.ClienteModalBean;
import br.com.bradesco.web.npcd.utils.NpcFacesUtils;
import br.com.bradesco.web.npcd.view.bean.BaseBean;

/**
 * Nome: EfetivacaoBoletoBean.java
 * 
 * Propósito:
 * <p>
 * </p>
 *
 * @author : BRQ<BR/>
 *         Equipe : Web <BR>
 * @version: 1.5 Parametro de compilação -d
 *
 * @see : Referencias externas.
 *
 *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel: Equipe
 *      Web _ Ajuste para deixar no padrão hexavision.
 */
@Named("efetivacaoBoletoBean")
@SessionScoped
public class EfetivacaoBoletoBean extends BaseBean implements Serializable {

    /** Variavel do tipo long. */
    private static final long serialVersionUID = 1L;
    private EfetivacaoBoletoViewHelper viewHelper = new EfetivacaoBoletoViewHelper();

    private final String STATE_ID = "NPCCIATX-EFETIVACAO";
    
    /* Objeto utilizado nas telas de Cliente */
    private ClienteSelecaoVO clienteSelecaoVO = new ClienteSelecaoVO();

    /* Objeto de entrada para a pesquisa */
    private BolAgexFiltroVO filtroVO = new BolAgexFiltroVO();
    /* Objeto de saída para a pesquisa */
    private BolAgexVO bolAgexVO = new BolAgexVO();
    /* objeto para o detalhar */
    private BolAgexListVO bolAgexListVO = new BolAgexListVO();
    /* objeto para excluir e confirmar */
    private StatusBolAtzFiltroVO filtroAtzExclVO = new StatusBolAtzFiltroVO();

    @Inject
    @Named("selectItemBean")
    private SelectItemBean selectItemBean;

    @Inject
    @Named("clienteModalBean")
    private ClienteModalBean clienteModalBean;

    @Inject
    @Named("bolAgexListService")
    private BolAgexListService bolAgexListService;

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
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String iniciar() {

        // Recarrega página se não for um postback ou se foi marcado para
        // recaregar
        if (!isPostback() || getIniciarPagina()) {
            setIniciarPagina(false);

            setFiltroVO(new BolAgexFiltroVO());
            setViewHelper(new EfetivacaoBoletoViewHelper());
            setBolAgexVO(new BolAgexVO());
            setClienteSelecaoVO(new ClienteSelecaoVO());
            setFiltroAtzExclVO(new StatusBolAtzFiltroVO());
            getViewHelper().setCodCpfCnpjSelecionado(Numeros.DOIS);
            
            getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
                       
            viewHelper.setComboProduto(selectItemBean.getProduto(EnumProduto.CODIGO_DA_MESA_MESA_TRADE.getCodigo(),
                    EnumProduto.CODIGO_CAMBIO_ZERO.getCodigo(), EnumProduto.CODIGO_COMPRA_VENDA_ZERO.getCodigo()));
            this.getViewHelper().setNomeStateIdLista(STATE_ID);
        }

        return "efeIncList";

    }

    /**
     * 
     * Nome: voltar
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String voltar() {
        return "efeIncList";
    }

    /**
     * 
     * Nome: getSelectItemRadioLista
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public List<SelectItem> getSelectItemRadioLista() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        for (int index = 0; index < getBolAgexVO().getLista().size(); index++) {
            list.add(new SelectItem(index, "", ""));
        }
        return list;
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
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void paginar() {
        filtroVO.setFlagBaixEstrn(Numeros.ZERO);
        setBolAgexVO(bolAgexListService.pesquisar(filtroVO,STATE_ID));
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
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public String detalhar() {
        int indice = SiteUtil.getInt(getViewHelper().getCodlistRadio());
        if (validarCodigoListaRadio()) {
            bolAgexListVO = bolAgexVO.getLista().get(indice);
            return "inclBoleto";
        }
        return "efeIncList";
    }

    /**
     * 
     * Nome: validarCodigoListaRadio
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 12/05/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarCodigoListaRadio() {
        if (SiteUtil.isEmptyOrNull(getViewHelper().getCodlistRadio())) {
            NpcFacesUtils.addInfoModalMessage("Selecione um item", false);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 
     * Nome: listenerPesquisarClienteNome
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteNome(AjaxBehaviorEvent e) {
		clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
		clienteModalBean.getViewHelper().setModalId("formEfetivacao\\:modalCliente");
		clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(Numeros.UM);
		clienteModalBean.getViewHelper().setPesqCpf(Boolean.FALSE);
		clienteModalBean.openModal();
		getViewHelper().setRenderModalCliente(Boolean.TRUE);
    }

    /**
     * 
     * Nome: closeModal
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void closeModal() {
    	if(clienteSelecaoVO.getCodCpfCnpj() != Numeros.UM){
        	getViewHelper().setCodCpfCnpjSelecionado(clienteSelecaoVO.getCodCpfCnpj());
    	} else {
    		clienteSelecaoVO.setCodCpfCnpj(getViewHelper().getCodCpfCnpjSelecionado());
    	}
        getViewHelper().setRenderModalCliente(Boolean.FALSE);
    }

    /**
     * 
     * Nome: listenerPesquisarClienteCpfCnpj
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerPesquisarClienteCpfCnpj(AjaxBehaviorEvent e) {
    	clienteSelecaoVO.setNomeBanco(null);
        clienteModalBean.setClienteSelecaoVO(clienteSelecaoVO);
        clienteModalBean.getViewHelper().setModalId("formEfetivacao\\:modalCliente");
        /*
         * clienteModalBean.getViewHelper().setCodCpfCnpjSelecionado(getViewHelper
         * ().getCodCpfCnpjSelecionado());
         */
        clienteModalBean.getViewHelper().setPesqCpf(Boolean.TRUE);
        clienteModalBean.openModal();
        getViewHelper().setRenderModalCliente(Boolean.TRUE);
    }

    /**
     * 
     * Nome: listenerMudaCpfCnpjCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void listenerMudaCpfCnpjCliente(AjaxBehaviorEvent e) {
        limpaCamposCliente();
    }

    /**
     * 
     * Nome: limpaCamposCliente
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    private void limpaCamposCliente() {
        this.clienteSelecaoVO.setCnpj(new CnpjDataType());
        this.clienteSelecaoVO.setCpf(new CpfDataType());
        this.clienteSelecaoVO.setNomeCliente(null);
        this.clienteSelecaoVO.setNomeBanco(null);
        this.clienteSelecaoVO.setCodAgencia(null);
        this.clienteSelecaoVO.setContaDv(null);
    }
    
    /**
     * 
     * Nome: limparGrid
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limparGrid(AjaxBehaviorEvent event) {
    	
    	bolAgexVO = null;
    	setBolAgexVO(bolAgexVO);
    
    }
    
    /**
     * 
     * Nome: limpar
     * 
     * Propósito: limpa campos e grid após pressionar botão limpar
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 30/09/2016 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao
     *      padrão hexavision.
     */
    public void limpar(AjaxBehaviorEvent event){
    	 setClienteSelecaoVO(new ClienteSelecaoVO());
        setFiltroVO(new BolAgexFiltroVO());
        setBolAgexVO(new BolAgexVO());
        limpaCamposCliente();
        clienteSelecaoVO.setCodCpfCnpj(Numeros.DOIS);
        getFiltroVO().setDataInicioFim(new CalendarioPeriodo(new Date(), new Date()));
    }
    
    /**
     * 
     * Nome: callbackMudarCliente
     * 
     * Propósito: Limpar campo de cliente quando o campo é alterado na pesquisa
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 03/03/2017 - Autor: BRQ - Responsavel: Equipe Web - Adequação ao padrão hexavision.
     */
    
    public void callbackMudarCliente(AjaxBehaviorEvent event){
    	if(SiteUtil.isEmptyOrNull(clienteSelecaoVO.getNomeCliente())){
    		  	setClienteSelecaoVO(new ClienteSelecaoVO());
    	}
    	limparGrid(event);
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
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void pesquisar(AjaxBehaviorEvent event) {

        // validar campos
        if (!validarDatas()) {

            getFiltroVO().setEcunicclicmbio(getClienteSelecaoVO().getCodCliente());
            getFiltroVO().setEstatus(Numeros.NUM56);
            getFiltroVO().setEnbletonegoccmbioano(SiteUtil.getInt(getFiltroVO().getEnbletonegoccmbioano()));
            this.getFiltroVO().setEcprodtservc(
                            this.getFiltroVO().getCprodtservc());
            if (SiteUtil.isEmptyOrNull(clienteSelecaoVO.getCnpj().getCnpjCampo1())) {

                getFiltroVO().setCnpj(getFiltroVO().getCnpj());

            } else if (SiteUtil.isEmptyOrNull(clienteSelecaoVO.getCpf().getCpfCampo1())) {

                getFiltroVO().setCpf(clienteSelecaoVO.getCpf());
                
            }
            
            
            filtroVO.setFlagBaixEstrn(Numeros.ZERO);
            bolAgexVO = bolAgexListService.pesquisar(filtroVO, STATE_ID);
        }
    }

    /**
     * 
     * Nome: validarDatas
     * 
     * Propósito:
     *
     * @param :
     * @return :
     * @throws :
     * @exception :
     * @see : Referencias externas.
     *
     *      Registro de Manutenção: 18/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public Boolean validarDatas() {
        Boolean retorno = Boolean.FALSE;

        if (getFiltroVO().getDataInicioFim().getInicio() == null
                || getFiltroVO().getDataInicioFim().getFim() == null) {
            retorno = false;
        } else if (getFiltroVO().getDataInicioFim().getFim()
                .before(getFiltroVO().getDataInicioFim().getInicio())) {

            NpcFacesUtils.addInfoModalMessage("O campo Data Inicial é maior que Data Final.", false);
            retorno = true;
        }

        return retorno;
    }

    /**
     * 
     * Nome: validarCpfCnpj
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
    public Boolean validarCpfCnpj() {
        Boolean retorno = Boolean.FALSE;
        if (getFiltroVO().getCnpj() == null && getFiltroVO().getCpf() == null) {
            BradescoFacesUtils.addGlobalErrorFacesMessage("O campo Cpf ou Cnpj deve ser preenchido.", "");
            retorno = Boolean.TRUE;
        }
        return retorno;
    }

    /**
     * 
     * Nome: validarFormExcluir
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
    public void validarFormExcluir(ActionEvent ae) {
        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formIncluirBoleto")) {

            getViewHelper().setRenderModalExcluir(Boolean.TRUE);
        }
    }

    /**
     * 
     * Nome: validarFormConfirmar
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
    public void validarFormConfirmar(ActionEvent ae) {
        // valida campos obrigatórios
        if (!SiteUtil.validarCampos("formIncluirBoleto")) {

            getViewHelper().setRenderModalConfirmar(Boolean.TRUE);
        }
    }

    /**
     * 
     * Nome: actionConfirmarExcluir
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
    public void actionConfirmarExcluir() {

        String result = SiteUtil.STRING_EMPTY;

        getViewHelper().setRenderModalExcluir(Boolean.FALSE);

        getFiltroAtzExclVO().setEstatusbletocmbio(Numeros.NUM6);
        getFiltroAtzExclVO().setEstatusbletoanter(Numeros.NUM56);

        getFiltroAtzExclVO().setEnbletonegoccmbio(getBolAgexListVO().getSnbletonegoccmbio());

        getFiltroAtzExclVO().setEsaldbletocmbio(getBolAgexListVO().getSvsdolimsensi());
        getFiltroAtzExclVO().setEvultestrnbaixa(getBolAgexListVO().getSvnegocmoedaestrg());

        getFiltroAtzExclVO().setEtmaxcontrprodt(getBolAgexListVO().getStdiaopercmbio());
        getFiltroAtzExclVO().setEcindcdmoedautlzd(getBolAgexListVO().getScindcdeconmmoeda());

        result = bolAgexListService.excluirConfirm(getFiltroAtzExclVO());

        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{efetivacaoBoletoBean.iniciar}",
                BradescoViewExceptionActionType.ACTION, "submit", false);
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
     *      Registro de Manutenção: 19/04/2016 - Autor: BRQ - Responsavel:
     *      Equipe Web - Adequação ao padrão hexavision.
     */
    public void actionConfirmar() {
        String result = SiteUtil.STRING_EMPTY;

        getViewHelper().setRenderModalConfirmar(Boolean.FALSE);

        getFiltroAtzExclVO().setEstatusbletocmbio(Numeros.NUM57);
        getFiltroAtzExclVO().setEstatusbletoanter(Numeros.NUM56);

        getFiltroAtzExclVO().setEnbletonegoccmbio(getBolAgexListVO().getSnbletonegoccmbio());

        getFiltroAtzExclVO().setEsaldbletocmbio(getBolAgexListVO().getSvsdolimsensi());
        getFiltroAtzExclVO().setEvultestrnbaixa(getBolAgexListVO().getSvnegocmoedaestrg());

        getFiltroAtzExclVO().setEtmaxcontrprodt(getBolAgexListVO().getStdiaopercmbio());
        getFiltroAtzExclVO().setEcindcdmoedautlzd(getBolAgexListVO().getScindcdeconmmoeda());

        result = bolAgexListService.excluirConfirm(getFiltroAtzExclVO());

        setIniciarPagina(true);

        BradescoFacesUtils.addInfoModalMessage(result, "#{efetivacaoBoletoBean.iniciar}",
                BradescoViewExceptionActionType.ACTION, "submit", false);
    }

    /**
     * 
     * Nome: actionFecharModalExcluir
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
    public void actionFecharModalExcluir(ActionEvent ae) {
        getViewHelper().setRenderModalExcluir(Boolean.FALSE);
    }

    /**
     * 
     * Nome: actionFecharModalConfirmar
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
    public void actionFecharModalConfirmar(ActionEvent ae) {
        getViewHelper().setRenderModalConfirmar(Boolean.FALSE);
    }

    /**
     * @return o valor do viewHelper
     */
    public EfetivacaoBoletoViewHelper getViewHelper() {
        return viewHelper;
    }

    /**
     * @param viewHelper
     *            seta o novo valor para o campo viewHelper
     */
    public void setViewHelper(EfetivacaoBoletoViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }

    /**
     * @return o valor do clienteSelecaoVO
     */
    public ClienteSelecaoVO getClienteSelecaoVO() {
        return clienteSelecaoVO;
    }

    /**
     * @param clienteSelecaoVO
     *            seta o novo valor para o campo clienteSelecaoVO
     */
    public void setClienteSelecaoVO(ClienteSelecaoVO clienteSelecaoVO) {
        this.clienteSelecaoVO = clienteSelecaoVO;
    }

    /**
     * @return o valor do filtroVO
     */
    public BolAgexFiltroVO getFiltroVO() {
        return filtroVO;
    }

    /**
     * @param filtroVO
     *            seta o novo valor para o campo filtroVO
     */
    public void setFiltroVO(BolAgexFiltroVO filtroVO) {
        this.filtroVO = filtroVO;
    }

    /**
     * @return o valor do bolAgexVO
     */
    public BolAgexVO getBolAgexVO() {
        return bolAgexVO;
    }

    /**
     * @param bolAgexVO
     *            seta o novo valor para o campo bolAgexVO
     */
    public void setBolAgexVO(BolAgexVO bolAgexVO) {
        this.bolAgexVO = bolAgexVO;
    }

    /**
     * @return o valor do bolAgexListVO
     */
    public BolAgexListVO getBolAgexListVO() {
        return bolAgexListVO;
    }

    /**
     * @param bolAgexListVO
     *            seta o novo valor para o campo bolAgexListVO
     */
    public void setBolAgexListVO(BolAgexListVO bolAgexListVO) {
        this.bolAgexListVO = bolAgexListVO;
    }

    /**
     * @return o valor do filtroAtzExclVO
     */
    public StatusBolAtzFiltroVO getFiltroAtzExclVO() {
        return filtroAtzExclVO;
    }

    /**
     * @param filtroAtzExclVO
     *            seta o novo valor para o campo filtroAtzExclVO
     */
    public void setFiltroAtzExclVO(StatusBolAtzFiltroVO filtroAtzExclVO) {
        this.filtroAtzExclVO = filtroAtzExclVO;
    }

    /**
     * @return o valor do selectItemBean
     */
    public SelectItemBean getSelectItemBean() {
        return selectItemBean;
    }

    /**
     * @param selectItemBean
     *            seta o novo valor para o campo selectItemBean
     */
    public void setSelectItemBean(SelectItemBean selectItemBean) {
        this.selectItemBean = selectItemBean;
    }

    /**
     * @return o valor do clienteModalBean
     */
    public ClienteModalBean getClienteModalBean() {
        return clienteModalBean;
    }

    /**
     * @param clienteModalBean
     *            seta o novo valor para o campo clienteModalBean
     */
    public void setClienteModalBean(ClienteModalBean clienteModalBean) {
        this.clienteModalBean = clienteModalBean;
    }

    /**
     * @return o valor do bolAgexListService
     */
    public BolAgexListService getBolAgexListService() {
        return bolAgexListService;
    }

    /**
     * @param bolAgexListService
     *            seta o novo valor para o campo bolAgexListService
     */
    public void setBolAgexListService(BolAgexListService bolAgexListService) {
        this.bolAgexListService = bolAgexListService;
    }

}
